package movies;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResultIdList {

    @XmlElement(name = "id", type = Integer.class)
    private List<Integer> ids;

    public ResultIdList() {
        ids = new ArrayList<>();
    }

    public ResultIdList(Map<String, Integer> map) {
        ids = new ArrayList<>(map.values());
    }
}
