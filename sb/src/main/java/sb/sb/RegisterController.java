package sb.sb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register") // This is where you specify the base url for this controller
public class RegisterController { 

  @Autowired  
  private RegisterRepository registerRepository; 
  
  @GetMapping("")  
  public String showRegistrationForm(Model model) {  
      model.addAttribute("user", new Register());  
      return "/register";  
  }  
  
  @PostMapping("")
    public void registerUser(@ModelAttribute("user") Register user, HttpServletResponse response) throws IOException {
    if (registerRepository.existsById(user.getId())) {
        response.sendRedirect("/register");
        return;
    }

    registerRepository.save(user);

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<script>alert('회원가입이 완료되었습니다.'); location.href='/';</script>");
    out.flush();
    
    }

}
