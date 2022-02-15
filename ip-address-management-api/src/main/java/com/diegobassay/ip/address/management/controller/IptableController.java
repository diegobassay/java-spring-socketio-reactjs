package com.diegobassay.ip.address.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RestController
@RequestMapping("/ip")
public class IptableController {

    static final Logger LOG = LoggerFactory.getLogger(IptableController.class);

}
