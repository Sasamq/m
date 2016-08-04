package com.hsh24.mall.item.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hsh24.mall.api.cart.ICartService;
import com.hsh24.mall.api.cart.bo.Cart;
import com.hsh24.mall.api.item.IItemService;
import com.hsh24.mall.api.item.bo.Item;
import com.hsh24.mall.framework.action.BaseAction;

/**
 * 
 * @author JiakunXu
 * 
 */
@Controller
@Scope("request")
public class ItemAction extends BaseAction {

	private static final long serialVersionUID = -8497315926605513479L;

	@Resource
	private IItemService itemService;

	@Resource
	private ICartService cartService;

	private List<Item> itemList;

	private List<Cart> cartList;

	private String itemId;

	private Item item;

	/**
	 * 
	 * @return
	 */
	public String list() {
		Long shopId = this.getShop().getShopId();

		itemList = itemService.getItemList(shopId, new Item());

		cartList = cartService.getCartList(this.getUser().getUserId(), shopId);

		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 */
	public String detail() {
		item = itemService.getItem(this.getShop().getShopId(), itemId);

		return SUCCESS;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}
