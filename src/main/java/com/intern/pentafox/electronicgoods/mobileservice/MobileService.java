package com.intern.pentafox.electronicgoods.mobileservice;

import com.intern.pentafox.electronicgoods.mobileentity.Mobile;

import java.util.List;

public interface MobileService {

     List<Mobile> getallMobiles();

    Mobile getMobileById(int id);

    Mobile getMobileByName(String name);
     void createMobiles(Mobile mobile);

     void updateMobile(int id , Mobile mobile);

    void deleteMobileById(int  id);
}
