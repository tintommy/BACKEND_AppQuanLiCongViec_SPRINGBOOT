package org.example.quanlycongviec.security;

import lombok.AllArgsConstructor;
import org.example.quanlycongviec.entity.NguoiDung;
import org.example.quanlycongviec.repository.NguoiDungRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service()
public class CustomUserDetailsService implements UserDetailsService {
    private NguoiDungRepository nguoiDungRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        NguoiDung temp = nguoiDungRepository.findByEmail(email);
//        if(temp==null){
//            GrantedAuthority authority = new SimpleGrantedAuthority("ABC");
//            return new User(
//                    "gmail.com",
//                    "abc",
//                    new ArrayList<GrantedAuthority>() {{
//                        add(authority);
//                    }}
//            );
//        }

        if (temp != null) {
            NguoiDung user = nguoiDungRepository.findById(temp.getMaNguoiDung())
                    .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));


            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");

            return new User(
                    email,
                    user.getMatKhau(),
                    new ArrayList<GrantedAuthority>() {{
                        add(authority);
                    }}
            );
        }
        throw new UsernameNotFoundException("Could not find email: " + email);

    }
}
