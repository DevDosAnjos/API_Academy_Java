package com.users.academyusers.services;

import com.users.academyusers.dto.RegisterRequest;
import com.users.academyusers.dto.UserRequest;
import com.users.academyusers.dto.UserResponse;
import com.users.academyusers.dto.UserUpdateResponse;
import com.example.common.events.users.UserRegisteredEvent;
import com.example.common.events.users.UserUpdatedEvent;
import com.users.academyusers.configs.RabbitMQConfig;
import com.users.academyusers.entities.User;
import com.example.common.enums.users.Belts;
import com.example.common.enums.users.UserRole;
import com.example.common.enums.users.UserStatus;
import com.users.academyusers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventPublisher eventPublisher;


    public UserResponse registerUser(RegisterRequest registerRequest) {
        User user = new User(registerRequest.name(),registerRequest.rg(),registerRequest.cpf(),registerRequest.dateOfBirth(),registerRequest.age(), registerRequest.weight(),registerRequest.height(),registerRequest.address(),registerRequest.cellphoneNumber(),registerRequest.email(),registerRequest.password(), Belts.WHITE, UserRole.STUDENT, UserStatus.PENDING);
        userRepository.save(user);
        UserRegisteredEvent event = new UserRegisteredEvent(user.getId(),user.getName(),user.getRg(),user.getCpf(),user.getDateOfBirth(),user.getAge(),user.getWeight(),user.getHeight(),user.getAddress(),user.getCellphoneNumber(),user.getEmail(),user.getBelts(),user.getUserRole(),user.getUserStatus());
        eventPublisher.publishEvent(RabbitMQConfig.USER_EVENT_EXCHANGE, RabbitMQConfig.USER_REGISTERED_ROUTING_KEY, event);
        return new UserResponse(user.getId(),user.getName(),user.getRg(),user.getCpf(),user.getDateOfBirth(),user.getAge(),user.getWeight(),user.getHeight(),user.getAddress(), user.getCellphoneNumber(),user.getEmail(),user.getUserStatus());
    }

    public UserUpdateResponse updateUser(User user, UserRequest userRequest) {
        User userOPT = userRepository.findById(user.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"User Not Found"));
        if (userRequest.name() != null){
            userOPT.setName(userRequest.name());
        }
        if (userRequest.rg() != null){
            userOPT.setRg(userRequest.rg());
        }
        if (userRequest.cpf() != null){
            userOPT.setCpf(userRequest.cpf());
        }
        if (userRequest.dateOfBirth() != null){
            userOPT.setDateOfBirth(userRequest.dateOfBirth());
        }
        if (userRequest.age() != null){
            userOPT.setAge(userRequest.age());
        }
        if (userRequest.weight() != null){
            userOPT.setWeight(userRequest.weight());
        }
        if (userRequest.height() != null){
            userOPT.setHeight(userRequest.height());
        }
        if (userRequest.cellphoneNumber() != null){
            userOPT.setCellphoneNumber(userRequest.cellphoneNumber());
        }
        if (userRequest.email() != null){
            userOPT.setEmail(userRequest.email());
        }
        if (userRequest.password() != null){
            userOPT.setPassword(userRequest.password());
        }
        if (userRequest.belts() != null){
            userOPT.setBelts(userRequest.belts());
        }
        if (userRequest.userRole() != null){
            userOPT.setUserRole(userRequest.userRole());
        }
        if (userRequest.userStatus() != null){
            userOPT.setUserStatus(userRequest.userStatus());
        }
        userRepository.save(userOPT);
        UserUpdatedEvent event = new UserUpdatedEvent(userOPT.getId(),userOPT.getName(),userOPT.getRg(),userOPT.getCpf(),userOPT.getDateOfBirth(),userOPT.getAge(),userOPT.getWeight(),userOPT.getHeight(),userOPT.getAddress(),userOPT.getCellphoneNumber(),userOPT.getEmail(),userOPT.getPassword(),userOPT.getBelts(),userOPT.getUserRole(),userOPT.getUserStatus());
        eventPublisher.publishEvent(RabbitMQConfig.USER_EVENT_EXCHANGE, RabbitMQConfig.USER_UPDATED_ROUTING_KEY, event);
        return new UserUpdateResponse(userOPT.getName(),userOPT.getRg(),userOPT.getCpf(),userOPT.getDateOfBirth(),userOPT.getAge(),userOPT.getWeight(),userOPT.getHeight(),userOPT.getAddress(),userOPT.getCellphoneNumber(),userOPT.getEmail(),userOPT.getPassword());
    }

}
