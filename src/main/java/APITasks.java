import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface APITasks {

    //LISTA TODAS AS TAREFAS
    @Headers("Student:1144002134")
    @GET("tasks")
    Call<List<Tarefa>> listaTarefas();

    //TRAZ UMA TAREFA POR ID
    @Headers("Student:1144002134")
    @GET("tasks/{id}")
    Call<Tarefa> listaTarefaId(@Path("id") int id);

    //CRIA UMA NOVA TAREFA
    @Headers("Student:1144002134")
    @POST("tasks")
    Call<Tarefa> criaTarefa(@Body Tarefa description);

    //EXCLUI UMA TAREFA POR ID
    @Headers("Student:1144002134")
    @DELETE("tasks/{id}")
    Call<Void> excluirTarefaId (@Path("id") int id);

    //ALTERA UMA TAREFA POR ID
    @Headers("Student:1144002134")
    @PUT("tasks/{id}")
    Call<Tarefa> alteraTarefaId(@Path("id") int id, @Body String description);

}
