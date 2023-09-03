package com.farras.lsb.ch3.security;

import com.farras.lsb.ch3.entitiy.UserAccount;
import com.farras.lsb.ch3.repository.UserManagementRepository;
import com.farras.lsb.ch3.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class SecurityConfig {

//    @Bean
//    public  UserDetailsService userService(){
//        UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        userDetailsManager.createUser(
//                User.withDefaultPasswordEncoder().username("user").password("password").roles("UMUM").build());
//
//        userDetailsManager.createUser(
//                User.withDefaultPasswordEncoder().username("admin").password("password").roles("ADMIN").build());
//
//        return userDetailsManager;
//    }

    @Bean
    UserDetailsService userService (UserRepository userRepository){
        System.out.println("Its get all User");

        return username -> {
            UserAccount account = userRepository.findByUsername(username);
            try {

                System.out.println("The user name :"+account.getUserName());
                System.out.println("The user name :"+account.getPassword());
                return account.asUser();
            }
            catch (Exception e){
                throw new UsernameNotFoundException("User tidak ada coy");

            }

        };
    }
//    @Bean
//    CommandLineRunner initUsers(UserManagementRepository repository){
//        System.out.println("Its saved all user");
////        System.out.println(repository.findByUsername("username").getUserName());
//       return n -> {
//           repository.save(new UserAccount("user","paswword","ROLE_USERS"));
//           repository.save(new UserAccount("admin","paswword","ROLE_ADMIN"));
//       };
//    }
}
