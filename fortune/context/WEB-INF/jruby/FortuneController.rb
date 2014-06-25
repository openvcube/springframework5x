require 'java' 

include_class 'org.springframework.web.servlet.ModelAndView'
include_class 'org.springframework.web.servlet.mvc.Controller'

include_class 'javax.servlet.http.HttpServletRequest'
include_class 'javax.servlet.http.HttpServletResponse'

class FortuneController < Controller

 $fortune1
 $fortune2
	
 def setFortune1(fortune1)
  $fortune1 = fortune1
 end

 def setFortune2(fortune2)
  $fortune2 = fortune2
 end

 def handleRequest(request, httpServletResponse)
    ModelAndView.new("tell", "fortune", $fortune1)
 end

end