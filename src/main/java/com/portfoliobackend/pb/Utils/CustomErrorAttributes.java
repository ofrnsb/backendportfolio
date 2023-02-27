package com.portfoliobackend.pb.Utils;

import java.util.Map;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

  @Override
  public Map<String, Object> getErrorAttributes(
    WebRequest webRequest,
    ErrorAttributeOptions options
  ) {
    Map<String, Object> errorAttributes = super.getErrorAttributes(
      webRequest,
      options
    );
    errorAttributes.remove("path");
    errorAttributes.remove("timestamp");
    return errorAttributes;
  }
}
