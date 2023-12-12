package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Configuration implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long configurationId;
    private String processor;
    private int ram;
	private int memory;
    private double screen;
    private String graphicCard;
    private String audioCard;
   
    
	public Long getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(Long configurationId) {
		this.configurationId = configurationId;
	}
	
	public String getProcessor() {
		return processor;
	}
	
	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}
	
	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public double getScreen() {
		return screen;
	}

	public void setScreen(double screen) {
		this.screen = screen;
	}

	public String getGraphicCard() {
		return graphicCard;
	}

	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}

	public String getAudioCard() {
		return audioCard;
	}

	public void setAudioCard(String audioCard) {
		this.audioCard = audioCard;
	}

	public Configuration(Long configurationId, String processor, int ram, int memory, double screen,
			String graphicCard, String audioCard) {
		this.configurationId = configurationId;
		this.processor = processor;
		this.ram = ram;
		this.memory = memory;
		this.screen = screen;
		this.graphicCard = graphicCard;
		this.audioCard = audioCard;
	}

	public Configuration() {
    	
    }
}
