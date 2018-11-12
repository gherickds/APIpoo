import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Main {
    public static void main(String args[]) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-35-166-113-35.us-west-2.compute.amazonaws.com/api/")

                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APITasks api = retrofit.create(APITasks.class);

        //CRIAR NOVA TAREFA
        try {
            Tarefa post = new Tarefa ();
            post.setDescription("MAIS UMA NOVA TAREFA");
            post.setStatus(true);
            Call<Tarefa> call = api.criaTarefa(post);

            Response<Tarefa> r = call.execute();

            Tarefa t = r.body();

            System.out.println("Nova tarefa criada : "+ t +"\n");

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //LISTA TODAS AS TAREFAS
        try {
            Call<List<Tarefa>> call = api.listaTarefas();

            Response<List<Tarefa>> r = call.execute();

            List<Tarefa> t = r.body();

            System.out.println("Lista de todas as tarefas : \n"+t+"\n");

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //LISTA TAREFAS PELO SEU ID
        try {
            Tarefa listById = new Tarefa ();
            Call<Tarefa> call = api.listaTarefaId(1427);

            Response<Tarefa> r = call.execute();

            Tarefa t = r.body();

            System.out.println("Tarefa buscada pelo ID : \n"+t+"\n");

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //ALTERA A TAREFA PELO SEU ID
        try {
        Tarefa updateById = new Tarefa ();
        Call<Tarefa> call = api.alteraTarefaId(1428, "TAREFA ALTERADA TESTE");
        Response<Tarefa> r = call.execute();

         Tarefa t = r.body();

         System.out.println("Tarefa Alterada : \n"+t+"\n");

        } catch (Exception e)
        {
        e.printStackTrace();
    }

        //EXCLUI UMA TAREFA PELO SEU ID
        try {
            Tarefa deleteById = new Tarefa ();
            Call<Void> call = api.excluirTarefaId(1427);

            Response<Void> r = call.execute();

            Void t = r.body();

            System.out.println("A tarefa foi deletada: \n"+t+"\n");

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
