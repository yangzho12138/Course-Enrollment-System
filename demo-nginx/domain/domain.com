server {
  listen 7081;

  location /courses/info/findCourse{
      default_type text/plain;
      proxy_pass http://backend;
  }

  location /courses/info/opList{
        default_type text/plain;
        proxy_pass http://backend;
  }

  location /courses/enrollment/addCourse{
        default type text/plain;
        proxy_pass http://backend;
  }

  location /courses/enrollment/submitCourses{
        default type text/plain;
        proxy_pass: http://backend;
  }
}