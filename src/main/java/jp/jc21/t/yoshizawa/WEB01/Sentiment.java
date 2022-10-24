package jp.jc21.t.yoshizawa.WEB01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Sentiment {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Sentiments message = getSentiment("I'm good");
		if (message != null) {
			System.out.println("Positive : " + message.documents[0].confidenceScores.positive);
			System.out.println("Neutral : " + message.documents[0].confidenceScores.neutral);
			System.out.println("Negative : " + message.documents[0].confidenceScores.negative);
		}
	}

	static Sentiments getSentiment(String s) throws IOException, URISyntaxException, InterruptedException {
		Gson gson = new Gson();

		String url = "https://r04jk3b11-text.cognitiveservices.azure.com/" + "text/analytics/v3.0/sentiment";
		Map<String, String> map = new HashMap<>();
		map.put("Ocp-Apim-Subscription-Key", "3f089ae60eda477e949d463f06bdd4cc");

		SDocs doc = new SDocs();
		doc.id = "1";
		doc.text = s;

		SSource src = new SSource();
		src.documents = new SDocs[1];
		src.documents[0] = doc;

		String jsonData = new Gson().toJson(src);

		InetSocketAddress proxy = new InetSocketAddress("172.17.0.2", 80);

		JsonReader reader = WebApiConnector.postJsonReader(url, proxy, map, jsonData);
		Sentiments message = null;
		if (reader != null) {
			message = gson.fromJson(reader, Sentiments.class);
			reader.close();
		}
		return message;
	}

}
class Sentiments {
	SDocuments[] documents;
	String[] errors;
	String modelVersion;
}
class SDocuments {
	ConfidenceScores confidenceScores;
	String id;
	Sentences[] sentences;
	String sentiment;
	String[] warnings;
}
class ConfidenceScores {
	float negative;
	float neutral;
	float positive;
}
class Sentences {
	Targets[] targets;
	ConfidenceScores confidenceScores;
	int length;
	int offset;
	Assessments[] assessments;
}
class Targets {
	ConfidenceScores confidenceScores;
	int length;
	int offset;
	Relations[] relations;
	String sentiment;
	String text;
}
class Relations {
	String ref;
	String relationType;
}
class Assessments {
	ConfidenceScores confidenceScores;
	boolean isNegatived;
	int length;
	int offset;
	String sentiment;
	String text;
}
class SSource {
	SDocs[] documents;
}

class SDocs {
	String id;
	String text;
}