package movies;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class ResultId {

    @XmlElement(name = "id")
    private Integer id;

    public ResultId() {
        id = 0;
    }

    public ResultId(Integer id) {
        this.id = id;
    }
}
