package com.digiwes.demo.ann.mgt.processing;


import com.digiwes.demo.ann.mgt.edmann.EDMKeyProperty;
import com.digiwes.demo.ann.mgt.edmann.EDMProperty;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import java.io.*;
import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created by liurl3 on 2016/3/31.
 */
@SupportedAnnotationTypes({"com.digiwes.demo.ann.mgt.edmann.EDMEntityType","com.digiwes.demo.ann.mgt.edmann.EDMProperty","com.digiwes.demo.ann.mgt.edmann.EDMKeyProperty"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class EDMProcessor extends AbstractProcessor {
  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
      Map<String,StringBuffer> elementMap = new HashMap<String,StringBuffer>();
      for (TypeElement te : annotations) {
          String elementType = te.toString();
          for (Element el : roundEnv.getElementsAnnotatedWith(te)) {
              Name simpleName = el.getSimpleName();
              if(elementType.endsWith("EDMEntityType")) {
                  try {
                      String beanPath = el.toString();
                      String packag = beanPath.substring(0, beanPath.lastIndexOf("."));
                      String name = beanPath.replace(packag + ".", "");
                      String filename = name + "ExtendEntityType.java";
                      String path =  "./target/generated-code/src/";
                      String path2 = packag.replace(".","/");
                      path = path + path2 + "/entity/";
                      File dirFile = new File(path);
                      if(!dirFile.exists() && !dirFile.isDirectory()){
                          dirFile.mkdirs();
                      }
                      File file = new File(path,filename);
                      file.createNewFile();
                      String newClassName = filename.substring(0,filename.lastIndexOf("."));
                      //将代码输出到文件
                      PrintWriter out = new PrintWriter(new FileOutputStream(file));
                      out.println("package " + packag + ".entity;" );
                      out.println("public class " + newClassName + "{" );
                      out.println("        String namespace = \"" + packag + "\";");
                      out.println("        String name = \"" + name + "\";");
                      out.println(elementMap.get(beanPath).toString());
                      out.println("}");
                      //关闭文件流
                      out.flush();
                      out.close();
                  } catch (IOException e) {
                     e.printStackTrace();
                  }
              }else{
                  StringBuffer propertys = new StringBuffer();
                  String value = "";
                  String printin = "";
                  if(elementType.endsWith("EDMProperty")){
                      EDMProperty edmProperty  = el.getAnnotation(EDMProperty.class);
                      try {
                          edmProperty.value();
                      }catch (MirroredTypeException me){
                          value = me.getTypeMirror().toString();
                      }
                      printin = "        Property " + simpleName + " = new Property(\""+simpleName+"\");";
                  }else if(elementType.endsWith("EDMKeyProperty")){
                      EDMKeyProperty edmKeyProperty  = el.getAnnotation(EDMKeyProperty.class);
                      try {
                          edmKeyProperty.value();
                      }catch (MirroredTypeException me){
                          value = me.getTypeMirror().toString();
                      }
                      printin = "        Property " + simpleName + " = new KeyProperty(\""+simpleName+"\");";
                  }
                  if(null != elementMap.get(value)) {
                      propertys = elementMap.get(value);
                  }
                  propertys.append(printin).append("\n");
                  elementMap.put(value, propertys);
              }
          }
      }

      return true;
  }

}
