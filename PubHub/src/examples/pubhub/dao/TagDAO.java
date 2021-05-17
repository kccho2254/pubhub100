package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.Book;
import examples.pubhub.model.Tag;

/**
 * Interface for our Data Access Object to handle database queries related to Book tags.
 */

public interface TagDAO {
	
	public List<Tag> getAllTags();
	public List<Tag> getTagsByBook(String isbn13);
	public List<Book> getBooksByTag(String tag); // This will require either a SQL JOIN statement or a nested query

	public boolean addTag(String isbn13, Tag tag);
	public boolean deleteTag(String isbn13, Tag tag);
}