package com.management.EmpManagement.Controller;

import com.management.EmpManagement.Service.PartialWfhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partial")
public class PartialController {

    @Autowired
    private PartialWfhService PartialWFHService;
}
