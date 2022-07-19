server {
  listen 7081;

  #find a course
  location /courses/info/findCourse{
      default_type text/plain;
      proxy_pass http://backend;
  }
}