package types;

public class ClientRecommendation {

	private Integer ClientID;
	private Integer RecommendationID;
	
	public ClientRecommendation(){
		
	}
	
	public ClientRecommendation(Integer ClientID,Integer RecommendationID){
		this.ClientID=ClientID;
		this.RecommendationID=RecommendationID;
	}
	
	
	public Integer getClientID() {
		return ClientID;
	}
	public void setClientID(Integer clientID) {
		ClientID = clientID;
	}
	public Integer getRecommendationID() {
		return RecommendationID;
	}
	public void setRecommendationID(Integer recommendationID) {
		RecommendationID = recommendationID;
	}
	
	
}
