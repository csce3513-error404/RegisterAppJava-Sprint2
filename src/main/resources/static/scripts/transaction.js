document.addEventListener("DOMContentLoaded", () => {
	const productElements = document.getElementById("transactionProduct").children;
	
	for (let i = 0; i < productElements.length; i++) {
		productElements[i].addEventListener("click", remove);
	}
	
	
	getPayment().addEventListener("click", payClick); 
	
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

function payClick(event) {
	window.location.assign("/pay");
}

function getPayment() {
	return document.getElementById("checkout");
}
