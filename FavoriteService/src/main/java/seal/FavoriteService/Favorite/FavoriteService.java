package seal.FavoriteService.Favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    public Favorite createFavorite(String userId, int subjectId) {
        Favorite favorite = new Favorite(userId, subjectId);
        return favoriteRepository.save(favorite);
    }

    public List<Favorite> getFavoriteByUserId(String userId) {
        return favoriteRepository.findByUserId(userId);
    }

    public Favorite deleteFavoriteById(int id) {
        Favorite favorite_object = favoriteRepository.findById(id).get();
        favoriteRepository.delete(favorite_object);
        return favorite_object;
    }
}