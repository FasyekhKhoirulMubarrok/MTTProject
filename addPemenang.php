<?php
	error_reporting(E_ERROR | E_PARSE);
	$c = new mysqli("localhost", "root","","gachaguess");


	if($c->connect_errno) {
		$arr = array("result" => "ERROR", 
					 "message" => "Failed to Connect");
		echo json_encode($arr);
		die();
	}
   if($_POST['namapemenang']) {
		$namapemenang = (String) $_POST['namapemenang'];
		$skor = (String) $_POST['skor'];
		$sql = "INSERT INTO pemenang(namaPemenang,skor) values ('$namapemenang', '$skor')";
		$c->query($sql);
		$arr = array("result" => "OK", 
			"sql"	=> $sql,
			"message" => "the winner has been added");
		echo json_encode($arr);
	} else {
		$arr = array("result" => "ERROR", 
			"message" => "data is empty");
		echo json_encode($arr);
	}
?>