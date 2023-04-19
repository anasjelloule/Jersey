package ma.voltify.jersey.Dtos;

import java.util.Date;

import jakarta.jws.WebResult;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.voltify.jersey.enums.TypeAccount;

@Data
@Builder
@XmlRootElement(name = "AccountDtosoap")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private String id;
    private double balance;
    private Date createdAt;
    @XmlTransient
    private Date updatedAt;
    @XmlAttribute
    private TypeAccount type;
    // @WebResult(name = "Customer")
    @XmlElement(name = "CustomerDto")
    private CustomerDto customerdto;

}
