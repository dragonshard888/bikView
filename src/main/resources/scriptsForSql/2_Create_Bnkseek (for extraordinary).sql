CREATE TABLE `bigbik`.`bnkseek` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `realy` VARCHAR(4) NULL,
  `pzn` VARCHAR(2) NULL,
  `uer` VARCHAR(1) NOT NULL,
  `rgn` VARCHAR(2) NOT NULL,
  `ind` VARCHAR(6) NULL,
  `tnp` VARCHAR(1) NULL,
  `nnp` VARCHAR(45) NULL,
  `bnkseekcol` VARCHAR(25) NULL,
  `addr` VARCHAR(30) NULL,
  `rkc` VARCHAR(9) NULL,
  `namep` VARCHAR(45) NOT NULL,
  `newnum` VARCHAR(9) NOT NULL,
  `telef` VARCHAR(25) NULL,
  `regn` VARCHAR(9) NULL,
  `okpo` VARCHAR(8) NULL,
  `dt_izm` DATETIME NOT NULL,
  `ksnp` VARCHAR(20) NULL,
  `date_in` DATETIME NOT NULL,
  `date_ch` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `newnum_UNIQUE` (`newnum` ASC),
  INDEX `fk_real_idx` (`realy` ASC),
  INDEX `fk_pzn_idx` (`pzn` ASC),
  INDEX `fk_uer_idx` (`uer` ASC),
  INDEX `fk_reg_idx` (`rgn` ASC),
  INDEX `fk_tnp_idx` (`tnp` ASC),
  CONSTRAINT `fk_real`
    FOREIGN KEY (`realy`)
    REFERENCES `bigbik`.`realy` (`realy`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pzn`
    FOREIGN KEY (`pzn`)
    REFERENCES `bigbik`.`pzn` (`pzn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_uer`
    FOREIGN KEY (`uer`)
    REFERENCES `bigbik`.`uer` (`uer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reg`
    FOREIGN KEY (`rgn`)
    REFERENCES `bigbik`.`reg` (`rgn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tnp`
    FOREIGN KEY (`tnp`)
    REFERENCES `bigbik`.`tnp` (`tnp`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
