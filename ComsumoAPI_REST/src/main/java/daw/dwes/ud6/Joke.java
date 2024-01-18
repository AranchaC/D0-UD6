package daw.dwes.ud6;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Joke(String type, String setup, String punchline, Integer id) {
	//{"type":"general","setup":"What is red and smells like blue paint?","punchline":"Red paint!","id":248}

}
