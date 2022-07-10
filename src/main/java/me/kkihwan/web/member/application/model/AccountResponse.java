package me.kkihwan.web.member.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountResponse {

	@JsonProperty("id")
	private Long id;

}
