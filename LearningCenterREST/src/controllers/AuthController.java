package controllers;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.AuthDAO;
import entities.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthDAO authDAO;

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public User register(HttpSession session, @RequestBody User user, HttpServletRequest request,
			HttpServletResponse response) {
		User returnedUser = authDAO.register(user);
		session.setAttribute("user", returnedUser);
		if (returnedUser == null) {
			response.setStatus(500);
		}
		return returnedUser;
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public User login(HttpSession session, @RequestBody User user, HttpServletRequest request,
			HttpServletResponse response) {
		User returnedUser = authDAO.login(user);
		session.setAttribute("user", returnedUser);
		if (returnedUser == null) {
			unauth(request, response);
		}
		return returnedUser;
	}

	@RequestMapping(path = "/logout", method = RequestMethod.POST)
	public Boolean logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		try {
			session.removeAttribute("user");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@RequestMapping(path = "/unauthorized")
	public HashMap<String, String> unauth(HttpServletRequest request, HttpServletResponse response) {
		response.setStatus(401);
		HashMap<String, String> returned = new HashMap<String, String>();
		returned.put("error", "Unauthorized");
		return returned;
	}
}
