package com.cybertek.bootstrap;

import com.cybertek.entity.Address;
import com.cybertek.entity.Person;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataGenerator  implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;


    @Override
    public void run(String... args) throws Exception {

        Person p1=new Person("Mike","Smith");
        Person p2=new Person("Kate","Kmith");
        Person p3=new Person("Mide","Bmith");

        Address a1=new Address("King St","22205");
        Address a2=new Address("Prince St","22206");
        Address a3=new Address("Queen St","22207");

//        p1.setAddresses(Arrays.asList(a1,a2));

        personRepository.saveAll(Arrays.asList(p1,p2,p3));

        a1.setPerson(p1);
        a2.setPerson(p1);
        a3.setPerson(p2);



        addressRepository.save(a1);
        addressRepository.save(a2);
        addressRepository.save(a3);




    }
}
