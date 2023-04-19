package ma.voltify.jersey.POJO;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import ma.voltify.jersey.Dtos.AccountDto;

@XmlRootElement
public class AccountsDtoPOJO {
    @XmlElement
    public List<AccountDto> account = new ArrayList<AccountDto>();
}
