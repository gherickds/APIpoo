public class Tarefa {

    private int id;
    private String description;
    private Boolean status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;

    }

    @Override
    public String toString() {
        return "Tarefa [id =" + id + ", description =" + description + ", status =" + status + "]";
    }
}
