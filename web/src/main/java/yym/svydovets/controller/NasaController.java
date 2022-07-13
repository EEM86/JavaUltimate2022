package yym.svydovets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import yym.svydovets.task.NasaService;

import java.io.IOException;

@RestController
public class NasaController {

  private NasaService service;

  @Autowired
  public NasaController(NasaService service) {
    this.service = service;
  }

  @GetMapping("/pictures/{sol}/largest")
  public String printLargestImage(@PathVariable int sol) throws IOException, InterruptedException {
    return service.findMaxImage(sol);
  }
}
