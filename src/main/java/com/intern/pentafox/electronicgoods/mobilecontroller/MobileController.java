package com.intern.pentafox.electronicgoods.mobilecontroller;

import com.intern.pentafox.electronicgoods.mobileentity.Mobile;
import com.intern.pentafox.electronicgoods.mobileservice.MobileServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mobile")
public class MobileController{
   @Autowired
   private MobileServiceImplementation service;
@GetMapping("fetchallmobiles")
     List<Mobile> listOfMobiles(){
      return service.getallMobiles();
}
@GetMapping("fetchmobilebyid/{id}")
    Mobile getMobile(@PathVariable int id){
    return service.getMobileById(id);
}
@GetMapping("fetchmobilebyname/{name}")
    Mobile getMobilewithName(@PathVariable String name){
        return service.getMobileByName(name);
    }
@PostMapping("insertmobiles")
    String insertMobile(@RequestBody Mobile mobile){
    service.createMobiles(mobile);
    return "Successfully inserted";
}
@PutMapping("updatebyid/{id}")
    String updateMobileById(@PathVariable int id,@RequestBody Mobile mobile){
    service.updateMobile(id , mobile);
    return "updated successfully";
}

@DeleteMapping("deletemobile/{id}")

    String deleteMobile(@PathVariable int id ){
    service.deleteMobileById(id);
    return "deleted successfully";
}
}



























