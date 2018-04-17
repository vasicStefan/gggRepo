package example.retrofit.impl;

import java.io.IOException;
import java.util.List;

import example.retrofit.ExampleRetrofit;
import model.Kategorija;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ExampleRetrofitImpl {

	public static void main(String[] args) throws IOException {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://localhost:8080/02Rest/rest/impl/")
				.addConverterFactory(JacksonConverterFactory.create()).build();

		ExampleRetrofit er = retrofit.create(ExampleRetrofit.class);
		Call<List<Kategorija>> odgovor = er.vratiSveKategorije();
		Response<List<Kategorija>> kategorijeResponse = odgovor.execute();
		List<Kategorija> kategorije = kategorijeResponse.body();
		for (Kategorija k : kategorije)
			System.out.println(k.getNaziv());

	}
}
