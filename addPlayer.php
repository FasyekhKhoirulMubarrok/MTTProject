<?php
	error_reporting(E_ERROR | E_PARSE);
	$c = new mysqli("localhost", "root","","gachaguess");


	if($c->connect_errno) {
		$arr = array("result" => "ERROR", 
					 "message" => "Failed to Connect");
		echo json_encode($arr);
		die();
	}
   if($_POST['kategori']) {
		$pemain1 = (String) $_POST['namapemain1'];
		$pemain2 = (String) $_POST['namapemain2'];
		$kategori = (String) $_POST['kategori'];
		$sql = "INSERT INTO pemain(namapemain1,namapemain2, kategori) values ('$pemain1', '$pemain2', '$kategori')";
		$c->query($sql);
		$arr = array("result" => "OK", 
			"sql"	=> $sql,
			"message" => "the palyer has been added");
		echo json_encode($arr);
	} else {
		$arr = array("result" => "ERROR", 
			"message" => "data is empty");
		echo json_encode($arr);
	}
?>