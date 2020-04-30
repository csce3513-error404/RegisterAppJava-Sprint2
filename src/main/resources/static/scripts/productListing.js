document.addEventListener("DOMContentLoaded", () => {
	const productListElements = document.getElementById("productsListing").children;

	for (let i = 0; i < productListElements.length; i++) {
		productListElements[i].addEventListener("click", productClick);
	}

	document.getElementById("searchLookup").addEventListener("click", productLookup);
});

function findClickedListItemElement(clickedTarget) {
	if (clickedTarget.tagName.toLowerCase() === "li") {
		return clickedTarget;
	} else {
		let ancestorIsListItem = false;
		let ancestorElement = clickedTarget.parentElement;

		while (!ancestorIsListItem && (ancestorElement != null)) {
			ancestorIsListItem = (ancestorElement.tagName.toLowerCase() === "li");

			if (!ancestorIsListItem) {
				ancestorElement = ancestorElement.parentElement;
			}
		}

		return (ancestorIsListItem ? ancestorElement : null);
	}
}

function productClick(event) {
	let listItem = findClickedListItemElement(event.target);

	window.location.assign(
		"/productDetail/"
		+ listItem.querySelector("input[name='productId'][type='hidden']").value);
}

function productLookup(event) {
	const searchElement = event.target.previousElementSibling;
	const productElements = document.getElementById("productsListing").children;

	for (let i = 0; i < productElements.length; i++) {
		const lookup = productElements[i].querySelector("productLookupCodeDisplay").innerHTML;

		if (lookup.toLowerCase().indexOf(searchElement.value.toLowerCase()) >= 0) {
			if (productElements[i].classList.contains("hidden")) {
				productElements[i].classList.remove("hidden");
			}
		} 
		else {
			if (!productElements[i].classList.contains("hidden")) {
				productElements[i].classList.add("hidden");
			}
		}
	}
}

function getT_IdElement() {
	return document.getElementById("transactionId");
}

function getT_Id() {
	return getT_IdElement().value;
}

function getProduct_IdElement() {
	return document.getElementById("productId");
}

function getProduct_Id() {
	return getProduct_IdElement().value;
}
