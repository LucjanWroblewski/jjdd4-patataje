package com.hydrozagadka;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "WATER_CONTAINERS")
public class WaterContainer {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "container_name")
    private String containerName;
    @Column(name = "station_name")
    private String stationName;
    @Column(name = "province_name")
    private String province;
    @OneToMany(mappedBy = "waterContainers", fetch = FetchType.EAGER)
    private List<History> history;
    @ManyToMany(mappedBy = "waterContainerId")
    List<User> users;

    public WaterContainer() {
    }

    public WaterContainer(Long id, String containerName, String stationName, String province, List<History> history) {
        this.id = id;
        this.containerName = containerName;
        this.stationName = stationName;
        this.province = province;
        this.history = history;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<History> getHistory() {
        return history;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterContainer that = (WaterContainer) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(containerName, that.containerName) &&
                Objects.equals(stationName, that.stationName) &&
                Objects.equals(province, that.province);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, containerName, stationName, province);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WaterContainer{");
        sb.append("id=").append(id);
        sb.append(", containerName='").append(containerName).append('\'');
        sb.append(", stationName='").append(stationName).append('\'');
        sb.append(", province='").append(province).append('\'');
        sb.append(", history=").append(history);
        sb.append('}');
        return sb.toString();
    }
}
