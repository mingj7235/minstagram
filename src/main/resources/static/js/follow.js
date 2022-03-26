// function follow(check, userId, i){
// 	let url = "/follow/"+userId;
// 	if(check){
// 		fetch(url,{
// 			method: "POST"
// 	    }).then(function(res){
// 			return res.text();
// 		}).then(function(res){
// 			if(res === "ok"){
// 				let follow_item_el = document.querySelector("#follow_item_"+i);
// 				follow_item_el.innerHTML = `<button onClick="follow(false, ${userId}, ${i})" class="following_btn">팔로잉</button>`;
// 			}
// 		});
// 	}else{
// 		fetch(url,{
// 			method: "DELETE"
// 	    }).then(function(res){
// 			return res.text();
// 		}).then(function(res){
// 			if(res === "ok"){
// 				let follow_item_el = document.querySelector("#follow_item_"+i);
// 				follow_item_el.innerHTML = `<button onClick="follow(true, ${userId}, ${i})" class="follow_btn">팔로우</button>`;
// 			}
// 		});
// 	}
// }

function follow(check){
	// true -> follow 하기
	// false -> unFollow 하기
	let toUserId = document.getElementById('toUserId').value;
	let url = "/follow/"+toUserId;
	if(check){
		fetch(url,{
			method: "POST"
		}).then(function(res){
			return res.text();
		}).then(function(res){
			if(res === "ok"){
				let follow_check_el = document.querySelector("#follow_check");
				follow_check_el.innerHTML = "<button onClick='follow(false);' class='profile_edit_btn'>팔로잉</button>";
			}
		});
	}else{
		fetch(url,{
			method: "DELETE"
		}).then(function(res){
			return res.text();
		}).then(function(res){
			if(res === "ok"){
				let follow_check_el = document.querySelector("#follow_check");
				follow_check_el.innerHTML = "<button onClick='follow(true);' class='profile_follow_btn'>팔로우</button>";
			}
		});
	}
}