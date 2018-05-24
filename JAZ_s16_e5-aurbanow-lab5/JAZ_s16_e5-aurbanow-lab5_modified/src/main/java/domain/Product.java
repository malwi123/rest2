package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@NamedQueries({
@NamedQuery(name="product.all", query="SELECT p FROM Product p"),
@NamedQuery(name="product.id", query="SELECT p FROM Product p WHERE p.id=:productId"),
@NamedQuery(name="product.name", query="SELECT p FROM Product p WHERE p.name= :productName"),
@NamedQuery(name="product.category", query="SELECT p FROM Product p WHERE p.category= :productCategory"),
@NamedQuery(name="product.price", query="SELECT p FROM Product p WHERE p.price > :from AND p.price < :to")
})
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String category;
	private int price;
	private List<Comment> comments = new ArrayList<Comment>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@XmlTransient
	@OneToMany(mappedBy="product")
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
}
