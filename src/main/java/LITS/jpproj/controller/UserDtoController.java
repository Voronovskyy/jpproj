package LITS.jpproj.controller;

import LITS.jpproj.dtos.UserDto;
import LITS.jpproj.service.UserDtoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@RestController
@RequestMapping(value = "/api")
public class UserDtoController {

    private UserDtoService userDtoService;

    @Autowired
    public UserDtoController(UserDtoService userDtoService) {
        this.userDtoService = userDtoService;
    }

    @PostMapping(value = "/login")
    @ApiOperation("auth")
    public ResponseEntity<?> auth(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userDtoService.auth(userDto.getLogin(), userDto.getPassword()));
    }

}
