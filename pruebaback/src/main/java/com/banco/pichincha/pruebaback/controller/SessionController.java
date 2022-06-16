package com.banco.pichincha.pruebaback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.pichincha.pruebaback.enities.Session;
import com.banco.pichincha.pruebaback.exception.UsuariosServiceException;
import com.banco.pichincha.pruebaback.service.SessionServiceI;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/semillero")
public class SessionController {
    @Autowired
    private SessionServiceI sessionService;

    @PostMapping(value = "/session")
    public ResponseEntity<Session> getSession(@RequestParam("name") String name,
            @RequestParam("password") String password, @RequestParam("mail") String mail)
            throws Exception {
        Session session = sessionService.getSession(name, password, mail);

        if (session != null) {
            return new ResponseEntity<Session>(session, HttpStatus.OK);
        } else {
            return new ResponseEntity<Session>(new Session(), HttpStatus.OK);
        }
    }
}
