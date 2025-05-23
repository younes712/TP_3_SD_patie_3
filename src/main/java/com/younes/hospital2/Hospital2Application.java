package com.younes.hospital2;

import com.younes.hospital2.entities.Patient;
import com.younes.hospital2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class Hospital2Application implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Hospital2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


//        patientRepository.save(new Patient(null,"Mohamed",LocalDate.now(),false,90));
//        patientRepository.save(new Patient(null,"Rachid",LocalDate.now(),true,100));
//        patientRepository.save(new Patient(null,"Imran",LocalDate.now(),false,140));

    }

    //@Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcuserDetailsManager) {
        return args -> {

            UserDetails u1 = jdbcuserDetailsManager.loadUserByUsername("user33");
            if ( u1 == null){
                jdbcuserDetailsManager.createUser(
                        User.withUsername("user33").password(passwordEncoder().encode("12345")).roles("USER").build()
                );
            }
            UserDetails u2 = jdbcuserDetailsManager.loadUserByUsername("admin2");
            if ( u2 == null){
                jdbcuserDetailsManager.createUser(
                        User.withUsername("admin2").password(passwordEncoder().encode("admin1234")).roles("USER","ADMIN").build()
                );
            }

        };
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
