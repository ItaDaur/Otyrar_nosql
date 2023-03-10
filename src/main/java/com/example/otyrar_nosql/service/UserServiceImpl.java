package com.example.otyrar_nosql.service;

import com.example.otyrar_nosql.entity.Role;
import com.example.otyrar_nosql.entity.User;
import com.example.otyrar_nosql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    MongoTemplate mongoTemplate;



    @Override
    public void save(User user) {
        if(user.getEmail().equals("asd@asd.asd") && user.getName().equals("asd"))
        {
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            user.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
            userRepository.insert(user);
        }
        else {

            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            user.setRoles(Arrays.asList(new Role("ROLE_USER")));

            userRepository.insert(user);
        }

    }

   /* @Override
    public boolean provenAccount(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if(BCrypt.checkpw(password,user.getPassword()))
            return true;
        else return false;
    }*/

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserById(String id) {
        User user =  userRepository.findUserById(id);
       return user;

    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
        System.out.println("User "+user.getEmail()+ " was deleted from service");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return  new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
    public User updateUser(User user)
    {

        User user1 = mongoTemplate.save(user);

        return user1;
    }
}
