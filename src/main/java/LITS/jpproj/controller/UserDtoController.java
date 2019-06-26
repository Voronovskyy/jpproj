package LITS.jpproj.controller;

import LITS.jpproj.dtos.UserDto;
import LITS.jpproj.service.UserDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api")
public class UserDtoController {

    private UserDtoService userDtoService;

    @Autowired
    public UserDtoController(UserDtoService userDtoService) {
        this.userDtoService = userDtoService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> auth(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userDtoService.auth(userDto.getLogin(), userDto.getPassword()));
    }

}
