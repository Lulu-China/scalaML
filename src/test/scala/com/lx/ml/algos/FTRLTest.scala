package com.lx.ml.algos

import com.lx.ml.algos.loss.LogLoss
import com.lx.ml.algos.optim.GradientDescent.FTRL_Proximal
import com.lx.ml.algos.utils.MatrixTools
import org.scalatest.FlatSpec

/**
  *
  * @project scalaML
  * @author lx on 12:21 AM 24/11/2017
  */

class FTRLTest extends FlatSpec {
  val (x, y) = DataHandler.binary_cls_data()
  val (new_x, new_y) = MatrixTools.shuffle(x, y.toArray.toSeq)

  val loss = new LogLoss

  {
    val model = new FTRL_Proximal(x.cols)
    println(s"this is ${model.getClass.getSimpleName} running!")
    model.set_verbose(true)
      .set_printPeriod(100)
      .set_loss(loss)
      .fit(x, y.toArray.toSeq)

    println(model.weight)
  }
}