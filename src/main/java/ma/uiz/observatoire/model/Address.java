package ma.uiz.observatoire.model;


import jakarta.annotation.Nullable;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@MappedSuperclass
public class Address extends BaseEntity {

    private String address1;

    private String address2;

    private String city;

    private String region;

    @Pattern(regexp = "(^$|[0-9]{5})|^$", message = "Please provide a valid Zip Code")
    @Nullable
    private String zipCode;
}
