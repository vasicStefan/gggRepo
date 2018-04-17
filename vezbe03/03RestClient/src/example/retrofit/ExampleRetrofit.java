package example.retrofit;

import java.util.List;

import model.Kategorija;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ExampleRetrofit {

	@GET("kategorije")
	Call<List<Kategorija>> vratiSveKategorije();
}
