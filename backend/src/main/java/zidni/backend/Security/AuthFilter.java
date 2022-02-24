package zidni.backend.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import zidni.backend.Contants.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest) request;
		HttpServletResponse httpResponse=(HttpServletResponse) response;
		String authHeader=httpRequest.getHeader("Authorization");
		if(authHeader!=null)
		{
			String authHeaderArr[]=authHeader.split("Bearer");
			if(authHeaderArr.length>1 && authHeaderArr[1]!=null)
			{
				String token=authHeaderArr[1];
				try
				{
					Claims claims=Jwts.parser().setSigningKey(Constants.API_SECRET_KEY).parseClaimsJws(token).getBody();
					httpRequest.setAttribute("id",claims.get("id"));
					httpRequest.setAttribute("mail",claims.get("mail"));
				}catch(Exception ex)
				{
					httpResponse.sendError(HttpStatus.FORBIDDEN.value(),"Invalid/Expired token");
					return;
				}
			}
			else
			{
				httpResponse.sendError(HttpStatus.FORBIDDEN.value(),"Autorization token must be bearer [Token]");
				return;
			}
		}
		else
		{
			httpResponse.sendError(HttpStatus.FORBIDDEN.value(),"Autorization token must provided");
			return;
		}
		chain.doFilter(httpRequest, httpResponse);
	}

}
