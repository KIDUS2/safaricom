package org.safari.et.Service;

import org.safari.et.dao.ValuesDao;
import org.safari.et.dto.RequestDto.ValuesRequestDto;
import org.safari.et.model.Values;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ValuesService {
    @EJB
    private ValuesDao valuesDao;



    public int Sum(ValuesRequestDto valuesRequestDto) {

            Values values =new Values();
            values.setNumbera(valuesRequestDto.getNumbera());
            values.setNumberb(valuesRequestDto.getNumberb());
        int add= values.getNumbera()+values.getNumberb();

//
            return  add;


    }   public int sub(ValuesRequestDto valuesRequestDto) {

            Values values =new Values();
            values.setNumbera(valuesRequestDto.getNumbera());
            values.setNumberb(valuesRequestDto.getNumberb());
        int add= values.getNumbera()-values.getNumberb();

//
            return  add;


    }   public int divid(ValuesRequestDto valuesRequestDto) {

            Values values =new Values();
            values.setNumbera(valuesRequestDto.getNumbera());
            values.setNumberb(valuesRequestDto.getNumberb());
        int add= values.getNumbera()/values.getNumberb();

//
            return  add;


    }   public int mult(ValuesRequestDto valuesRequestDto) {

            Values values =new Values();
            values.setNumbera(valuesRequestDto.getNumbera());
            values.setNumberb(valuesRequestDto.getNumberb());
        int add= values.getNumbera()*values.getNumberb();

//
            return  add;


    }
}
