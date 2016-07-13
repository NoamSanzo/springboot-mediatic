package fr.iocean.application.media;

import java.util.List;

public interface MediaRepositoryCustom {

	List<Media> search(String titre, String type, String auteur);
}
