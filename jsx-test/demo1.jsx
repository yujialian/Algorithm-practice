var profile = <div>
    <img src="avatar.png" className="profile" />
    <h3>{[user.firstName, user.lastName].join(" ")}</h3>
    </div>;
/*
var profile = React.createElement(
	"div",
	null,
	React.createElement("img", { src: "avatar.png", className: "profile" }),
	React.createElement(
		"h3",
		null,
		[user.firstName, user.lastName].join(" ")
	)
);
*/
