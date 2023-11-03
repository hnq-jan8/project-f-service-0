//package vn.ladystudio.servicef.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Slf4j
//@Component
//public class TokenFilter extends OncePerRequestFilter {
//
//    @Value("${project_f.security.public-urls: ''}")
//    private String publicUrls;
//
//    @Override
//    protected void doFilterInternal(
//            @NotNull HttpServletRequest request,
//            @NotNull HttpServletResponse response,
//            FilterChain filterChain
//    ) throws ServletException, IOException {
//
//        final String authHeader = request.getHeader("Authorization");
//        final String token;
//        final String username;
//
//        try {
//            // check if request url is !public
//            if (!isPublicUrl(request.getServletPath())) {
//                log.info("request.getServletPath(): " + request.getServletPath());
//
//
//                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//                    filterChain.doFilter(request, response);
//                    return;
//                }
//                token = authHeader.substring(7);
//                // user
//
//
//            }
//        } catch (Exception e) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//        }
//    }
//
//    private boolean isPublicUrl(String requestURI) {
//        String[] publicUrls = this.publicUrls.replaceAll(" ", "").split(",");
//        for (String publicUrl : publicUrls) {
//            if (requestURI.startsWith(publicUrl)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
